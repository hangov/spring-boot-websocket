package com.soft1721.janyue.api.mapper;

import com.soft1721.janyue.api.entity.Comment;
import com.soft1721.janyue.api.entity.vo.CommentVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentMapper {
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "uId",column = "u_id"),
            @Result(property = "aId",column = "a_id"),
            @Result(property = "content",column = "content"),
            @Result(property = "commentTime",column = "comment_time"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "avatar",column = "avatar")
    })
    @Select("SELECT a.*,b.nickname,b.avatar FROM t_comment a LEFT JOIN t_user b ON a.u_id=b.id WHERE a.a_id=#{aId} ORDER By id DESC")
    List<CommentVO> selectCommentsByAId(int aId);

    @Insert("INSERT INTO t_comment(u_id,a_id,content,comment_time) VALUES(#{uId}, #{aId}, #{content},#{commentTime}) ")
    void insert(Comment comment);
}


