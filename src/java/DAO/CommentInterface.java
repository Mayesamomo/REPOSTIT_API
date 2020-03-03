/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Comment;
import java.util.List;

/**
 *
 * @author micha
 */
public interface CommentInterface  {
   public List<Comment> getUserComments(int user_id);
    public List<Comment> getPostComments(int post_id);
    public List<Comment> getAllComments();
    //public boolean checkIfExist(int comment_id,String comment,int post_id); //if comment is already made on thesame posts by thesame us
    public boolean MakeComment(Comment comments);
    public int countComments();
    
}
