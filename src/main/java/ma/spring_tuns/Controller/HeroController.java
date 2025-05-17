package ma.spring_tuns.Controller;


import ma.spring_tuns.Dto.HeroRequestDto;
import ma.spring_tuns.Dto.HeroResponseDto;
import ma.spring_tuns.Service.HeroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heros")
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public ResponseEntity<List<HeroResponseDto>> getAllHeros(){
        List<HeroResponseDto> heros = heroService.getAllHeros();
        return ResponseEntity.ok(heros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeroResponseDto> getHeroById(@PathVariable Long id){
        HeroResponseDto hero = heroService.getHeroById(id);
        return ResponseEntity.ok(hero);
    }

    @PostMapping("/create-hero")
    public ResponseEntity<HeroResponseDto> saveHero(@RequestBody HeroRequestDto heroRequestDto){
        HeroResponseDto hero= heroService.createHero(heroRequestDto);
        return ResponseEntity.ok(hero);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HeroResponseDto> updateHero(@PathVariable Long id , @RequestBody HeroRequestDto heroRequestDto){
        HeroResponseDto heroResponseDto = heroService.updateHero(heroRequestDto,id);
        return ResponseEntity.ok(heroResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHero(@PathVariable Long id){
        heroService.deleteHero(id);
    }
}
