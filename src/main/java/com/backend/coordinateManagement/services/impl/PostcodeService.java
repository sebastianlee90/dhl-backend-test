package com.backend.coordinateManagement.services.impl;

import com.backend.coordinateManagement.dto.PostcodeDTO;
import com.backend.coordinateManagement.repository.jooq.PostcodeRepositoryJooq;
import com.backend.coordinateManagement.services.IPostcodeService;
import com.backend.coordinateManagement.util.LogUtil;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PostcodeService implements IPostcodeService {
    private final PostcodeRepositoryJooq postcodeRepositoryJooq;

    // Read data from the CSV file
    public List<PostcodeDTO> getPostcodeList() {
        log.info(LogUtil.ENTRY_SERVICES, "getCategoryList");
        return postcodeRepositoryJooq.getPostcodeList();
    }

    // Write data to the CSV file
    // public void writeCsv(List<PostcodeOutcode> postcodeOutcodes) throws IOException {
    //     try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_PATH))) {
    //         // Write the header row
    //         writer.writeNext(new String[]{"id", "postcode", "latitude", "longitude"});

    //         // Write each record
    //         for (PostcodeOutcode postcodeOutcode : postcodeOutcodes) {
    //             writer.writeNext(new String[]{
    //                     String.valueOf(postcodeOutcode.getId()),
    //                     postcodeOutcode.getPostcode(),
    //                     String.valueOf(postcodeOutcode.getLatitude()),
    //                     String.valueOf(postcodeOutcode.getLongitude())
    //             });
    //         }
    //     }
    // }
}