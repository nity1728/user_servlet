package com.cs.servlet;

import com.cs.entity.User;
import com.cs.service.impl.UserServiceImpl;
import com.cs.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String comm=request.getParameter("comm");

        UserServiceImpl usi = new UserServiceImpl();

        //分页显示所有用户信息
        if(comm.equals("list")) {
            String pageNO = request.getParameter("indexno");
            if (pageNO == null || pageNO == "") {
                pageNO = "1";
            }
            int pno = Integer.parseInt(pageNO);
            PageSupport ps = new PageSupport();
            ps.setCurrentPageNo(pno);
            ps.setPageSize(3);
            try {
                ps.setTotalCount(usi.findByCountUser());
                List<User> list = usi.findByPageUserInfo(ps.getCurrentPageNo(), ps.getPageSize());
                if (list.size() > 0 && list != null) {
                    request.getSession().setAttribute("lists", list);
                    request.getSession().setAttribute("ps", ps);
                    response.sendRedirect("list.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //显示个人用户信息
        if(comm.equals("query")){
            int id=Integer.parseInt(request.getParameter("id"));
            User user;
            try {
                user=usi.findUserById(id);
                request.getSession().setAttribute("user",user);
                response.sendRedirect("show.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //删除用户
        if(comm.equals("del")){
            boolean flag=false;
            int id=Integer.parseInt(request.getParameter("id"));
            try {
                flag=usi.delUserById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(flag){
                response.sendRedirect("index.jsp");
            }
            else {
                response.sendRedirect("list.jsp");
            }
        }

        //修改用户信息
        if(comm.equals("update")){
            int id=Integer.parseInt(request.getParameter("id"));
            request.getSession().setAttribute("updateId",id);
            response.sendRedirect("update.jsp");
        }

        if(comm.equals("updateOne")){
            int id=Integer.parseInt(request.getParameter("userId"));
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String sex=request.getParameter("sex");
            String date=request.getParameter("date");
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            String pic=request.getParameter("pic");
            boolean flag=false;
            try {
                Date date1=format.parse(date);
                User user=new User(id,username,password,sex,date1,pic);
                flag=usi.updateUserById(user);
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(flag){
                response.sendRedirect("index.jsp");
            }
            else {
                response.sendRedirect("faild.jsp");
            }
        }

        //添加用户
        if(comm.equals("add")){
            response.sendRedirect("add.jsp");
        }

        if(comm.equals("doadd")){
            int id=Integer.parseInt(request.getParameter("userId"));
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String sex=request.getParameter("sex");
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            Date date= null;
            try {
                date = format.parse(request.getParameter("date"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String pic=null;

            //将信息录入User
            User user= new User(username,password,sex,date,pic);

            boolean flag=false;
            UserServiceImpl userService=new UserServiceImpl();
            //添加用户
            try {
                flag=userService.addUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(flag){
                response.sendRedirect("index.jsp");
            }else {
                response.sendRedirect("faild.jsp");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request,response);
    }
}
