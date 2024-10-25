package com.hk.board.test;
import java.util.List;

import com.hk.board.daos.UserDao;
import com.hk.board.dtos.UserDto;

public class MainTest {
   public static void main(String[] args) {
      UserDao dao=new UserDao();
      
      List<UserDto> userList=dao.getAllUser();
      for(int i = 0;i<userList.size();i++) {
         System.out.println(userList.get(i));
      }
   }
}
