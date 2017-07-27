package com.yihaomen.mybatis.inter;
import java.util.List;
import com.yihaomen.mybatis.model.User;
import com.yihaomen.mybatis.model.Article;

public interface IUserOperation { 

    public List<Article> getUserArticles(int id);
}