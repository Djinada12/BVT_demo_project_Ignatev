package ru.mtuci.BVT_demo1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long>
{
    //@Query(value = "Select * FROM File_table WHERE file_name?", nativeQuery = true)
    FileEntity  findByFileName(String fileName);
    //Optional<FileEntity> findBySignature(String signature);
}
