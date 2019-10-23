package com.tww.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tww.base.ApiResult;
import com.tww.base.Page;
import com.tww.user.entity.User;
import com.tww.user.entity.UserQuery;
import com.tww.user.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * 
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Resource(name=UserService.BEAN_ID)
	private UserService userService;

	@RequestMapping(value = "/query/page", method = RequestMethod.POST,produces="application/json")
	public ApiResult<PageInfo<User>> queryUserPage(@RequestBody Page<UserQuery> page){
		ApiResult<PageInfo<User>> result=new ApiResult<PageInfo<User>>();
		if(page!=null){
			PageHelper.startPage(page.getPageNum(),page.getPageSize());
	        List<User> userList = userService.getUserList(page.getData());  
	        PageInfo<User> pagehelper = new PageInfo<>(userList);
			result.setSuccess(true);
			result.setMessage("查询成功");
			result.setData(pagehelper);
			result.setCode("200");
		}else{
			result.setSuccess(false);
			result.setMessage("查询失败");
			result.setCode("100");
		}
        return result;
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST,produces="application/json")
	public ApiResult<List<User>> queryUser(@RequestBody UserQuery apiParam){
		ApiResult<List<User>> result=new ApiResult<List<User>>();
		List<User> list=userService.getUserList(apiParam);
		result.setSuccess(true);
		result.setMessage("查询成功");
		result.setData(list);
		result.setCode("200");
        return result;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST,produces="application/json")
	public ApiResult<String> addUser(@RequestBody User apiParam){
		ApiResult<String> result=new ApiResult<String>();
		try {
			userService.insertUser(apiParam);
		}catch (ArithmeticException e){
			result.setSuccess(true);
			result.setMessage("新增失败");
			result.setData("新增失败");
			result.setCode("1");
		}
        result.setSuccess(true);
        result.setMessage("新增成功");
        result.setData("新增成功");
        result.setCode("0");
        return result;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST,produces="application/json")
	public ApiResult<String> updateUser(@RequestBody User apiParam){
		ApiResult<String> result=new ApiResult<String>();
		if(apiParam!=null){
			userService.updateUser(apiParam);
			result.setSuccess(true);
			result.setMessage("修改成功");
			result.setData("修改成功");
			result.setCode("200");
		}else{
			result.setSuccess(true);
			result.setMessage("修改失败");
			result.setData("修改失败");
			result.setCode("100");
		}
        return result;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST,produces="application/json")
	public ApiResult<String> deleteUser(@RequestBody User apiParam){
		ApiResult<String> result=new ApiResult<String>();
		if(apiParam!=null){
			userService.deleteUser(apiParam);
			result.setSuccess(true);
			result.setMessage("删除成功");
			result.setData("删除成功");
			result.setCode("200");
		}else{
			result.setSuccess(true);
			result.setMessage("删除失败");
			result.setData("删除失败");
			result.setCode("100");
		}
        return result;
	}
}
