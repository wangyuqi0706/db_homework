package org.scu_db.demo.Repository;

import org.scu_db.demo.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleRepository extends JpaRepository<Title, String> {

    @Query(value = "SELECT * FROM Title WHERE CallNumber in (SELECT CallNumber FROM Book WHERE Name = 'Iliad' OR Name = 'Odyssey')", nativeQuery = true)
    List<Title> findTargetTitle();
}
