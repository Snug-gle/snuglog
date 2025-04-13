package in.snuglog.api.repository;

import in.snuglog.api.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}