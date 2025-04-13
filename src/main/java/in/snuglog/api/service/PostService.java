package in.snuglog.api.service;

import in.snuglog.api.domain.Post;
import in.snuglog.api.repository.PostRepository;
import in.snuglog.api.request.PostCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  public void write(PostCreate postCreate) {

    Post post = new Post(
        null,
        postCreate.getTitle(),
        postCreate.getContent()
    );

    postRepository.save(post);

  }


}
