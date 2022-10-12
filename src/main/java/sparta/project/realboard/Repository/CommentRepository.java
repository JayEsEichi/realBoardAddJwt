package sparta.project.realboard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sparta.project.realboard.Entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findByBoardid(Long id);
}
