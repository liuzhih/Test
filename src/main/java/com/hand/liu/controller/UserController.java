package com.hand.liu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.hand.liu.model.Man;
import com.hand.liu.model.User;
import com.hand.liu.service.UserService;


@Controller
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping(value="/news",method = RequestMethod.POST)
	public ModelAndView news(User user){
		
		userService.add(user);
		List<User> list =userService.select();
		System.out.println(list.size());
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("/one");
		return mav;

	}
	
	
	@RequestMapping(value="/findall",method = RequestMethod.POST)
	public ModelAndView getAll(){

		List<User> list =userService.select();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("/one");
		return mav;

	}
	
	
	@RequestMapping(value="/delete",method =RequestMethod.GET)
	public ModelAndView delete(int id){
		System.out.println("sssssssssssssssssssssssssssss");
		System.out.println(id);
		userService.delete(id);
		
		List<User> list =userService.select();
		ModelAndView mav = new ModelAndView();
		System.out.println(list);
		mav.addObject("list", list);
		mav.setViewName("/one");
		return mav;

	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public ModelAndView search(int id){
		System.out.println("ssasdasdasdasda");
		User u = userService.searchByid(id);
		
		
		ModelAndView mav = new ModelAndView();
		System.out.println(u);
		mav.addObject("u", u);
		mav.setViewName("/update");
		return mav;

	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request,User user){
		System.out.println(user.getName());
		userService.update(user);
		List<User> list =userService.select();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("/one");
		return mav;

	}
	
	

    @RequestMapping(value = "regist", method = RequestMethod.POST)
    public String regist(HttpServletResponse resp,Man user) {
        System.out.println("111111");
        System.out.println(user.getuAccount());
      /*  try {
            userService.saveUser(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        return "index";
    }
	
    
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void login(HttpServletRequest request,HttpServletResponse resp, Man user,String code,String validate) {
        System.out.println("2222");
        System.out.println(code);
        System.out.println(validate);
        System.out.println("45465");
        if(code.equals(validate)){
        	List<User> listu = userService.select();
            User lu = new User();
            lu.setId(111);
            lu.setName("333");

    		String jo = JSON.toJSONString(lu);
    		
    		System.out.println(jo);
    		  
    		resp.setContentType("text/html;charset=utf-8");
    		PrintWriter out;
    		
    		try {
    			out = resp.getWriter();
    			out.print(jo);
    			out.close();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
        
        /*try {
            List<User> ul = userService.checkUser(user);
            if (ul.size() > 0) {
                a = "tpls/home";

            } else {
                a = "/";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        // return "index";

    }
}
