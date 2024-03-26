package mate.academy.webintro.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.skill.CreateSkillRequestDto;
import mate.academy.webintro.dto.skill.SkillDto;
import mate.academy.webintro.service.skill.SkillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/skills")
public class SkillController {
    private final SkillService skillService;

    @GetMapping
    public List<SkillDto> findAll() {
        return skillService.findAll();
    }

    @PostMapping
    public SkillDto save(@RequestBody CreateSkillRequestDto requestDto) {
        return skillService.save(requestDto);
    }
}
