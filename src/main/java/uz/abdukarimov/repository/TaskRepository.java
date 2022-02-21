package uz.abdukarimov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.abdukarimov.entity.task.Task;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "delete from task where id = ?1;", nativeQuery = true)
    Optional<Task> delete(Long aLong);

    @Query(value = "update task set title = ?2, deadline = ?3, description = ?4, completed = ?5, updated_at = current_timestamp where id = ?1", nativeQuery = true)
    void update(Long id, String title, Date deadline, String description, boolean completed);

    List<Task> findByUserId(Long userId);
}
