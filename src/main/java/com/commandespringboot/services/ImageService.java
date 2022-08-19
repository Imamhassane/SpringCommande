package com.commandespringboot.services;

import com.commandespringboot.models.Boisson;
import com.commandespringboot.models.Burger;
import com.commandespringboot.models.Image;
import com.commandespringboot.models.ProduitAttributes;
import com.commandespringboot.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;



    public List<Image> listAll(){
        return imageRepository.findAll();
    }
    public Image saveImage(Image image){
        return  imageRepository.save(image);
    }
    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }
    public Optional<Image> getById(Long id){
        return imageRepository.findById(id);
    }
}
