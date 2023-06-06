package cm.cti.serviceutilisateur.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseDto<BodyResponse> {
    private BodyResponse body;
    private List<String> message;
    private HttpStatus status;

}
