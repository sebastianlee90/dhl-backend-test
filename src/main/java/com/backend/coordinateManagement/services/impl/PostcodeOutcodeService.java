package com.backend.coordinateManagement.services.impl;

import com.backend.coordinateManagement.model.PostcodeOutcode;
import com.backend.coordinateManagement.services.IPostcodeOutcodeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PostcodeOutcodeService implements IPostcodeOutcodeService {

    // Read data from the CSV file
    public List<PostcodeOutcode> readCsv() {
        List<PostcodeOutcode> postcodeOutcodes = new ArrayList<>();
        // try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE_PATH))) {
        //     String[] line;
        //     boolean isHeader = true;
        //     while ((line = reader.readNext()) != null) {
        //         // Skip the header row
        //         if (isHeader) {
        //             isHeader = false;
        //             continue;
        //         }
        //         PostcodeOutcode postcodeOutcode = new PostcodeOutcode();
        //         postcodeOutcode.setId(Integer.parseInt(line[0]));
        //         postcodeOutcode.setPostcode(line[1]);
        //         postcodeOutcode.setLatitude(Double.parseDouble(line[2]));
        //         postcodeOutcode.setLongitude(Double.parseDouble(line[3]));
        //         postcodeOutcodes.add(postcodeOutcode);
        //     }
        // }
        return postcodeOutcodes;
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