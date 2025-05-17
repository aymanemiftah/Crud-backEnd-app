package ma.spring_tuns.Service;

import ma.spring_tuns.Dto.HeroRequestDto;
import ma.spring_tuns.Dto.HeroResponseDto;
import ma.spring_tuns.Entity.Hero;
import ma.spring_tuns.Mapper.HeroMapper;
import ma.spring_tuns.Repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroService {

    private final HeroRepository heroRepository;


    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<HeroResponseDto> getAllHeros(){
        List<Hero> heroes= heroRepository.findAllByDeletedAtIsNull();
        return heroes.stream().map(HeroMapper::toDto).collect(Collectors.toList());
    }

    public HeroResponseDto getHeroById(Long id){
        Hero hero= heroRepository.findByIdAndDeletedAtIsNull(id);
        return HeroMapper.toDto(hero);
    }

    public HeroResponseDto createHero(HeroRequestDto heroRequestDto){
        Hero hero = HeroMapper.toEntity(heroRequestDto);
        Hero createHero = Hero.builder()
                .heroName(hero.getHeroName())
                .power(hero.getPower()).build();
        return HeroMapper.toDto(heroRepository.save(createHero));
    }

    public HeroResponseDto updateHero(HeroRequestDto heroRequestDto , Long id){
        Hero hero = heroRepository.findByIdAndDeletedAtIsNull(id);
        hero.setHeroName(heroRequestDto.getHeroName());
        hero.setPower(heroRequestDto.getPower());
        return HeroMapper.toDto(heroRepository.save(hero));
    }

    public void deleteHero(Long id){
         heroRepository.deleteById(id);
    }

}
