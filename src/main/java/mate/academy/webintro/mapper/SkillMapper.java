package mate.academy.webintro.mapper;

import mate.academy.webintro.config.MapperConfig;
import mate.academy.webintro.dto.skill.CreateSkillRequestDto;
import mate.academy.webintro.dto.skill.SkillDto;
import mate.academy.webintro.model.Skill;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface SkillMapper {
    SkillDto toDto(Skill skill);

    Skill toModel(CreateSkillRequestDto requestDto);
}
