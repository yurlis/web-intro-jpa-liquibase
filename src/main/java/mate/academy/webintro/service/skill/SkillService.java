package mate.academy.webintro.service.skill;

import java.util.List;
import mate.academy.webintro.dto.skill.CreateSkillRequestDto;
import mate.academy.webintro.dto.skill.SkillDto;

public interface SkillService {
    SkillDto save(CreateSkillRequestDto requestDto);

    List<SkillDto> findAll();
}
