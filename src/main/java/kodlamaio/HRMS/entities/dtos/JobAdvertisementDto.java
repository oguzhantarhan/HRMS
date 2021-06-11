package kodlamaio.HRMS.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
private int id;
private String companyName;
private String ProfessionName;
private int countOfPosition;
private LocalDate adsPublishDate;
private LocalDate applicationDeadline;

}
