package ru.mtuci.BVT_demo1;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "File_table")
@Data
public class FileEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "file_name", nullable = false)
    private  String fileName;

    private  String contentType;

    @Lob
    private byte[] data;
}
