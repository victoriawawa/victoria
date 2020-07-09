package cn.ianzhang.automation.data.persona;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Enterprise {
    @Builder.Default
    private final String situation = "连续生产/开工类企事业单位";
}
