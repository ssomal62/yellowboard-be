package com.yellowstone.yellowboardbe.repository;

import com.yellowstone.yellowboardbe.entity.CommentEntity;
import com.yellowstone.yellowboardbe.repository.resultSet.GetCommentListResultSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    @Query(
            value = "SELECT  " +
                    "U.nickname AS nickName, " +
                    "U.profile_image AS profileImage, " +
                    "C.write_datetime AS writeDatetime, " +
                    "C.content AS content " +
                    "FROM comment AS C " +
                    "INNER JOIN user AS U " +
                    "On C.user_email = U.email " +
                    "WHERE " +
                    "C.board_number = ?1 " +
                    "ORDER BY write_datetime DESC",
            nativeQuery = true
    )
    List<GetCommentListResultSet> getCommentList(Integer boardNumber);
}
