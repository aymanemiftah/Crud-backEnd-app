package ma.spring_tuns.Dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class HeroResponseDto {
    private Long id;
    private String heroName;
    private BigInteger power;
}
