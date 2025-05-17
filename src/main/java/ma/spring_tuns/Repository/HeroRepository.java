package ma.spring_tuns.Repository;

import ma.spring_tuns.Entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero,Long> {
    List<Hero> findAllByDeletedAtIsNull();

    Hero findByIdAndDeletedAtIsNull(Long id);

}
