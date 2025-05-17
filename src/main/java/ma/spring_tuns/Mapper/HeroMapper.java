package ma.spring_tuns.Mapper;

import ma.spring_tuns.Dto.HeroRequestDto;
import ma.spring_tuns.Dto.HeroResponseDto;
import ma.spring_tuns.Entity.Hero;

public class HeroMapper {
    public static HeroResponseDto toDto(Hero hero){
        HeroResponseDto heroResponseDto = new HeroResponseDto();
        heroResponseDto.setId(hero.getId());
        heroResponseDto.setHeroName(hero.getHeroName());
        heroResponseDto.setPower(hero.getPower());
        return heroResponseDto;
    }
    public static  Hero toEntity(HeroRequestDto heroRequestDto){
        Hero hero = new Hero();
        hero.setHeroName(heroRequestDto.getHeroName());
        hero.setPower(heroRequestDto.getPower());
        return hero;
    }
}
