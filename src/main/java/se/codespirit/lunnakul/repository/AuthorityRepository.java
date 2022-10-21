package se.codespirit.lunnakul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.codespirit.lunnakul.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
