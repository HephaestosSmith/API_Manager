package com.ruoyi.web.core.config;

import com.ruoyi.common.config.RuoYiConfig;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * OpenAPI 配置 (springdoc-openapi)
 * 適用於 Swagger 介面文件顯示
 */
@Configuration
public class SwaggerConfig {

    @Autowired
    private RuoYiConfig ruoyiConfig;

    @Value("${swagger.enabled:true}")
    private boolean enabled;

    @Value("${swagger.pathMapping:}")
    private String pathMapping;

    /**
     * 主配置 - OpenAPI 基本資訊與 Token 安全設定
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("標題：管理系統_介面文件")
                        .description("描述：用於管理集團旗下公司的人員資訊")
                        .version("版本號:" + ruoyiConfig.getVersion())
                        .contact(new Contact()
                                .name(ruoyiConfig.getName())
                                .email("") // 可填寫 Email
                                .url("")) // 可填寫網站
                )
                .addSecurityItem(new SecurityRequirement().addList("Authorization"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("Authorization",
                                new SecurityScheme()
                                        .name("Authorization")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                );
    }

    /**
     * 分組 API（可選，這邊只做一組 default）
     */
    @Bean
    public GroupedOpenApi defaultApiGroup() {
        return GroupedOpenApi.builder()
                .group("default")
                .pathsToMatch("/**")
                .addOperationCustomizer((operation, handlerMethod) -> {
                    if (!enabled) {
                        operation.setDeprecated(true); // 如果禁用，標記為廢棄
                    }
                    return operation;
                })
                .build();
    }
}