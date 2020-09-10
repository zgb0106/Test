package com.neuedu.utils;

public interface ConstantUtil {
    //输入
    String ERROR_LOGIN = "用户名或密码错误，请重新输入";
    String ERROR_PRINT = "输入有误，请重新输入!!!";
    String ERROR_PASSWORD_TEST = "两次密码输入不一致，请重新添加";

    String ERROR_INPUT_FAIL = "\033[31m"+"输入不合法，请重新输入"+"\033[0m";

    //用户模块
    String USER_ADD_SUCCESS = "\033[32m"+"用户添加成功"+"\033[0m";
    String USER_ADD_FAIL = "\033[31m"+"用户添加失败,该用户已存在"+"\033[0m";

    String USER_DELETE_SUCCESS ="\033[32m"+"删除用户成功"+"\033[0m";
    String USER_DELETE_FAIL = "\033[31m"+"删除用户失败"+"\033[0m";

    String USER_VIEW_FAIL = "\033[31m"+"查看用户失败，该用户不存在"+"\033[0m";

    String USER_CHANGEPASS_SUCCESS = "\033[32m"+"修改密码成功"+"\033[0m";
    String USER_CHANGEPASS_FAIL = "\033[31m"+"修改密码失败，该用户不存在"+"\033[0m";

    String USER_CHECKUSER_SUCCESS = "\033[32m"+"用户审核成功"+"\033[0m";
    String USER_CHECKUSER_FAIL = "\033[31m"+"该用户不存在，审核失败"+"\033[0m";
    //图书模块
    String BOOK_ADD_SUCCESS = "\033[32m"+"添加图书成功"+"\033[0m";
    String BOOK_ADD_FAIL = "\033[31m"+"添加图书失败,该图书已存在"+"\033[0m";

    String BOOK_DELETE_SUCCESS = "\033[32m"+"删除图书成功"+"\033[0m";
    String BOOK_DELETE_FAIL = "\033[31m"+"删除图书失败,该图书不存在"+"\033[0m";

    String BOOK_CHANGE_SUCCESS = "\033[32m"+"修改图书成功"+"\033[0m";
    String BOOK_CHANGE_FAIL = "\033[31m"+"修改图书失败,该图书不存在"+"\033[0m";
    String BOOK_CHANGE_FATL2 = "\033[31m"+"修改失败，发生未知错误"+"\033[0m";

    String BOOK_VIEW_FAIL = "\033[31m"+"查询图书失败,该图书不存在"+"\033[0m";

    //借阅
    String BORROW_ADD_SUCCESS = "\033[32m"+"借阅图书成功"+"\033[0m";
    String BORROW_ADD_FAIL = "\033[31m"+"借阅图书失败,请重新选择"+"\033[0m";
    String BORROW_RETURN_SUCCESS = "\033[32m"+"归还图书成功"+"\033[0m";
    String BORROW_RETURN_FAIL = "\033[31m"+"归还图书失败,查找不到"+"\033[0m";
}
