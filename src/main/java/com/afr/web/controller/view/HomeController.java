package com.afr.web.controller.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.afr.exceptions.JsonValidationException;
import com.afr.model.Driver;
import com.afr.model.DriverStanding;
import com.afr.model.Location;
import com.afr.model.Race;
import com.afr.model.Result;
import com.afr.model.Season;
import com.afr.model.Team;
import com.afr.model.TeamStanding;
import com.afr.model.Tier;
import com.afr.service.DriverService;
import com.afr.service.LocationService;
import com.afr.service.RaceService;
import com.afr.service.ResultService;
import com.afr.service.SeasonService;
import com.afr.service.TeamService;
import com.afr.service.TierService;
import com.afr.web.controller.request.*;
import com.afr.web.controller.responses.*;
import com.afr.web.controller.validator.*;

@Controller
public class HomeController {
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private TierService tierService;
	
	@Autowired
	private SeasonService seasonService;
	
	@Autowired
	private RaceService raceService;
	
	@Autowired
	private ResultService resultService;
	
	@RequestMapping({"/","/home"})
	public ModelAndView redirectIndex(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/home");
		
		Race nextRace = raceService.getNextRace();
		
		Race lastRace = raceService.getLastRace();
		List<Result> lastRaceResults = resultService.findResultsByRace(lastRace);
		
		Map<Driver, DriverStanding> driverStandings = new HashMap<Driver, DriverStanding>();
		Map<Team, TeamStanding> constructorStandings =  new HashMap<Team, TeamStanding>();
		
		List<Result> allResults = resultService.findAllResults();
		
		for (Result result : allResults) {
			if (driverStandings.containsKey(result.getDriver())) {
				driverStandings.get(result.getDriver()).updatePoints(result.getPoints());
				driverStandings.get(result.getDriver()).setTeam(result.getTeam()); 
			} else {
				DriverStanding ds = new DriverStanding();
				ds.setDriver(result.getDriver());
				ds.setPoints(result.getPoints());
				ds.setTeam(result.getTeam());
				driverStandings.put(result.getDriver(), ds);
			}
			
			if (constructorStandings.containsKey(result.getTeam())) {
				constructorStandings.get(result.getTeam()).updatePoints(result.getPoints());
				List<Driver> drivers = constructorStandings.get(result.getTeam()).getDrivers();
				if (!drivers.contains(result.getDriver())) {
					drivers.add(result.getDriver());
					constructorStandings.get(result.getTeam()).setDrivers(drivers);
				}
			} else {
				TeamStanding ds = new TeamStanding();
				ds.setTeam(result.getTeam());
				ds.setPoints(result.getPoints());
				
				List<Driver> drivers = new ArrayList<Driver>();
				drivers.add(result.getDriver());
				ds.setDrivers(drivers);
				
				constructorStandings.put(result.getTeam(), ds);
			}
		}
		
		List<DriverStanding> sortedDriverStandings = new ArrayList<>(driverStandings.values());
		List<TeamStanding> sortedTeamStandings = new ArrayList<>(constructorStandings.values());
		
		Collections.sort(sortedDriverStandings, Collections.reverseOrder());
		Collections.sort(sortedTeamStandings, Collections.reverseOrder());
		
		mv.addObject("nextRace", nextRace);
		mv.addObject("timeZone", TimeZone.getDefault());
		mv.addObject("lastRace", lastRace);
		mv.addObject("lastRaceResults", lastRaceResults);
		mv.addObject("driverStandings", sortedDriverStandings);
		mv.addObject("constructorStandings", sortedTeamStandings);
		
		return mv;
	}
	
	@RequestMapping({"/login"})
	public ModelAndView redirectLogin(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/login");
		return mv;
	}
	
	@RequestMapping({"/accessDenied"})
	public ModelAndView redirectAccessDenied(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/accessDenied");
		return mv;
	}
	
	@RequestMapping(value = "/admin/{page}")
    public ModelAndView redirectAdminPages(Model model, @PathVariable(value = "page") String page) {
		ModelAndView mv = new ModelAndView("admin/" + page);
		if (page.equals("drivers")) {
			mv.addObject("drivers", driverService.findAllDrivers());
		} else if (page.equals("locations")) {
			mv.addObject("locations", locationService.findAllLocations());
		} else if (page.equals("teams")) {
			mv.addObject("teams", teamService.findAllTeams());
		} else if (page.equals("tiers")) {
			mv.addObject("tiers", tierService.findAllTiers());
		} else if (page.equals("seasons")) {
			mv.addObject("tiers", tierService.findAllTiers());
			mv.addObject("seasons", seasonService.findAllSeasons());
		} else if (page.equals("races")) {
			mv.addObject("races", raceService.findAllRaces());
			mv.addObject("locations", locationService.findAllLocations());
			mv.addObject("seasons", seasonService.findAllSeasons());
			mv.addObject("tiers", tierService.findAllTiers());
		} else if (page.equals("results")) {
			mv.addObject("races", raceService.findAllRaces());
			mv.addObject("drivers", driverService.findAllDrivers());
			mv.addObject("teams", teamService.findAllTeams());
		}
		
        return mv;
    }
	
	 @PostMapping(value = "/admin/saveDriver")
	 @ResponseBody
	 public DriverJsonResponse saveDriver(@RequestBody DriverJsonRequest reqJson) {
		 DriverJsonResponse resJson = new DriverJsonResponse();
		 
		 try {
			 DriverRequestValidator.validate(reqJson);
		 } catch (JsonValidationException e) {
			 resJson.setErrorMessages(e.getValidationErrors());
			 resJson.setValidated(false);
			 
			 return resJson;
		 }
		 
		 resJson.setValidated(true);
		 Driver driver;
		 
		 if (reqJson.getId() != null) {
			driver = driverService.findByID(reqJson.getId());
		 } else {
			 driver = new Driver();
		 }
		 
		 driver.setAvatar(reqJson.getAvatar());
		 driver.setName(reqJson.getName());
		 driver.setNumber(reqJson.getNumber());
		 driver.setNationality(reqJson.getNationality());
		 
		 if (reqJson.getId() != null) 
			 driverService.updateDriver(driver);
		 else
			 driverService.saveDriver(driver);
		 
		 resJson.setDriver(driver);
		 
		 return resJson;
	 }
	 
	 @PostMapping(value = "/admin/saveLocation")
	 @ResponseBody
	 public LocationJsonResponse saveLocation(@RequestBody LocationJsonRequest reqJson) {
		 LocationJsonResponse resJson = new LocationJsonResponse();
		 
		 try {
			 LocationRequestValidator.validate(reqJson);
		 } catch (JsonValidationException e) {
			 resJson.setErrorMessages(e.getValidationErrors());
			 resJson.setValidated(false);
			 
			 return resJson;
		 }
		 
		 resJson.setValidated(true);
		 Location location;
		 
		 if (reqJson.getId() != null) {
			location = locationService.findByID(reqJson.getId());
		 } else {
			 location = new Location();
		 }
		 
		 location.setAltName(reqJson.getAltName());
		 location.setName(reqJson.getName());
		 location.setMap(reqJson.getMap());
		 
		 if (reqJson.getId() != null) 
			 locationService.updateLocation(location);
		 else
			 locationService.saveLocation(location);
		 
		 resJson.setLocation(location);
		 
		 return resJson;
	 }
	 
	 @PostMapping(value = "/admin/saveTeam")
	 @ResponseBody
	 public TeamJsonResponse saveTeam(@RequestBody TeamJsonRequest reqJson) {
		 TeamJsonResponse resJson = new TeamJsonResponse();
		 
		 try {
			 TeamRequestValidator.validate(reqJson);
		 } catch (JsonValidationException e) {
			 resJson.setErrorMessages(e.getValidationErrors());
			 resJson.setValidated(false);
			 
			 return resJson;
		 }
		 
		 resJson.setValidated(true);
		 Team team;
		 
		 if (reqJson.getId() != null) {
			 team = teamService.findByID(reqJson.getId());
		 } else {
			 team = new Team();
		 }
		 
		 team.setColour(reqJson.getColour());
		 team.setName(reqJson.getName());
		 team.setCar(reqJson.getCar());
		 team.setLogo(reqJson.getLogo());
		 
		 if (reqJson.getId() != null) 
			 teamService.updateTeam(team);
		 else
			 teamService.saveTeam(team);
		 
		 resJson.setTeam(team);
		 
		 return resJson;
	 }
	 
	 @PostMapping(value = "/admin/saveTier")
	 @ResponseBody
	 public TierJsonResponse saveTier(@RequestBody TierJsonRequest reqJson) {
		 TierJsonResponse resJson = new TierJsonResponse();
		 
		 try {
			 TierRequestValidator.validate(reqJson);
		 } catch (JsonValidationException e) {
			 resJson.setErrorMessages(e.getValidationErrors());
			 resJson.setValidated(false);
			 
			 return resJson;
		 }
		 
		 resJson.setValidated(true);
		 Tier tier;
		 
		 if (reqJson.getId() != null) {
			 tier = tierService.findByID(reqJson.getId());
		 } else {
			 tier = new Tier();
		 }
		 
		 tier.setName(reqJson.getName());
		 
		 if (reqJson.getId() != null) 
			 tierService.updateTier(tier);
		 else
			 tierService.saveTier(tier);
		 
		 resJson.setTier(tier);
		 
		 return resJson;
	 }
	 
	 @PostMapping(value = "/admin/saveSeason")
	 @ResponseBody
	 public SeasonJsonResponse saveSeason(@RequestBody SeasonJsonRequest reqJson) {
		 SeasonJsonResponse resJson = new SeasonJsonResponse();
		 
		 try {
			 SeasonRequestValidator.validate(reqJson);
		 } catch (JsonValidationException e) {
			 resJson.setErrorMessages(e.getValidationErrors());
			 resJson.setValidated(false);
			 
			 return resJson;
		 }
		 
		 resJson.setValidated(true);
		 Season season;
		 
		 if (reqJson.getId() != null) {
			 season = seasonService.findByID(reqJson.getId());
		 } else {
			 season = new Season();
		 }
		 
		 season.setNumber(reqJson.getNumber());
		 season.setGame(reqJson.getGame());
		 
		 Tier tier = tierService.findByID(Integer.parseInt(reqJson.getTierId()));
		 season.setTier(tier);
		 
		 if (reqJson.getId() != null) 
			 seasonService.updateSeason(season);
		 else
			 seasonService.saveSeason(season);
		 
		 resJson.setSeason(season);
		 
		 return resJson;
	 }
	 
	 @PostMapping(value = "/admin/saveRace")
	 @ResponseBody
	 public RaceJsonResponse saveRace(@RequestBody RaceJsonRequest reqJson) {
		 RaceJsonResponse resJson = new RaceJsonResponse();
		 
		 try {
			 RaceRequestValidator.validate(reqJson);
		 } catch (JsonValidationException e) {
			 resJson.setErrorMessages(e.getValidationErrors());
			 resJson.setValidated(false);
			 
			 return resJson;
		 }
		 
		 resJson.setValidated(true);
		 Race race;
		 
		 if (reqJson.getId() != null) {
			 race = raceService.findByID(reqJson.getId());
		 } else {
			 race = new Race();
		 }
		 
		 System.out.println(Calendar.getInstance().getTimeZone());
		 DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm z");
		 Date date;
		try {
			date = format.parse(reqJson.getDate());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			if (!calendar.getTimeZone().inDaylightTime(date))
				calendar.add(Calendar.HOUR, 1);
			
			race.setDate(calendar.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 Season season = seasonService.findByID(Integer.parseInt(reqJson.getSeasonId()));
		 race.setSeason(season);
		 
		 Location location = locationService.findByID(Integer.parseInt(reqJson.getLocationId()));
		 race.setLocation(location);
		 
		 if (reqJson.getId() != null) 
			 raceService.updateRace(race);
		 else
			 raceService.saveRace(race);
		 
		 resJson.setRace(race);
		 
		 return resJson;
	 }
	 
	 @GetMapping(value = "/admin/getResults")
	 @ResponseBody
	 public ResultJsonResponse getResults(@RequestParam Integer raceId) {
		 ResultJsonResponse resJson = new ResultJsonResponse();
		 Race race = raceService.findByID(raceId);
		 
		 List<Result> results = resultService.findResultsByRace(race);
		 if (results.size() > 0) {
			 resJson.setValidated(true);
			 resJson.setResults(results);
		 } else {
			 resJson.setValidated(false);
		 }
		 
		 
		 return resJson;
	 }
	 
	 @PostMapping(value = "/admin/saveResults")
	 @ResponseBody
	 public ResultJsonResponse saveResults(@RequestBody ResultJsonRequest reqJson) {
		 ResultJsonResponse resJson = new ResultJsonResponse();
		 
		 try {
			 ResultRequestValidator.validate(reqJson);
		 } catch (JsonValidationException e) {
			 resJson.setErrorMessages(e.getValidationErrors());
			 resJson.setValidated(false);
			 
			 return resJson;
		 }
		 resJson.setValidated(true);
		 
		 int raceId = Integer.parseInt(reqJson.getRaceId());
		 Race race = raceService.findByID(raceId);
		 
		 for (int i = 0; i < reqJson.getResults().size(); i++) {
			 Map<String, String> result = reqJson.getResults().get(i);
			 
			 if (result == null || result.get("driver") == null)
				 continue;
			 
			 Result res;
			 if (result.get("id") == null || result.get("id").length() == 0)
				 res = new Result();
			 else 
				 res = resultService.findByID(Integer.parseInt(result.get("id")));
			 
			 Driver driver = driverService.findByID(Integer.parseInt(result.get("driver")));
			 Team team = teamService.findByID(Integer.parseInt(result.get("team")));
			 
			 res.setRace(race);
			 res.setDriver(driver);
			 res.setTeam(team);
			 res.setPosition(result.get("position"));
			 res.setPoints(Double.parseDouble(result.get("points")));
			 
			 if (result.get("id") == null || result.get("id").length() == 0)
				 resultService.saveResult(res);
			 else
				 resultService.updateResult(res);
		 }
		 
		 resJson.setResults(resultService.findResultsByRace(race));
		 
		 return resJson;
	 }
}