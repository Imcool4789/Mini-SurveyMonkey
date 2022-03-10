package Question;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
    public interface QuestionRepository extends CrudRepository<QuestionModel, Long> {
        QuestionModel findById(long id);
        List<QuestionModel> findAll();
    }
