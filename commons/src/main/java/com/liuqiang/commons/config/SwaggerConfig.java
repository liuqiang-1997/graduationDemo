package com.liuqiang.commons.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author LiuQiang
 * @date 4:27 下午
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket studentApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("RoleApi")
                .apiInfo(studentApiInfo())
                .select()
                //只显示api路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/role/.*")))
                .build();

    }

    @Bean
    public Docket teacherApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("permissionApi")
                .apiInfo(teacherApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/permission/.*")))
                .build();

    }

    @Bean
    public Docket counselorApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("rolePermissionApi")
                .apiInfo(counselorApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/role/permission/.*")))
                .build();

    }

    @Bean
    public Docket adminApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("gradeApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/grade/.*")))
                .build();

    }

    @Bean
    public Docket userApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("interviewApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/interview/.*")))
                .build();

    }
    @Bean
    public Docket monthlyApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("monthlyApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/monthly/.*")))
                .build();

    }
    @Bean
    public Docket practiceApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("practiceApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/practice/.*")))
                .build();

    }
    @Bean
    public Docket resumeApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("resumeApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/resume/.*")))
                .build();

    }
    @Bean
    public Docket replyApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("replyApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/reply/.*")))
                .build();

    }
    @Bean
    public Docket scoreApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("scoreApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/score/.*")))
                .build();

    }
    @Bean
    public Docket specialtyApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("specialtyApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/specialty/.*")))
                .build();

    }
    @Bean
    public Docket workApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("workApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/work/.*")))
                .build();

    }
    @Bean
    public Docket relationApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("relationApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/relation/.*")))
                .build();

    }
    @Bean
    public Docket userInfoApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("userinfoApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/user/info/.*")))
                .build();

    }
    @Bean
    public Docket syslogApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("syslogApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/syslog/.*")))
                .build();

    }
    @Bean
    public Docket accountApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("accountApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/account/.*")))
                .build();

    }

    private ApiInfo accountApiInfo() {

        return new ApiInfoBuilder()
                .title("账户接口")
                .description("本文档描述了账户业务接口定义")
                .version("1.0")
                .build();
    }

    private ApiInfo syslogApiInfo() {

        return new ApiInfoBuilder()
                .title("日志接口")
                .description("本文档描述了日志业务接口定义")
                .version("1.0")
                .build();
    }

    private ApiInfo userInfoApiInfo() {

        return new ApiInfoBuilder()
                .title("用户信息接口")
                .description("本文档描述了用户信息业务接口定义")
                .version("1.0")
                .build();
    }

    private ApiInfo relationApiInfo() {

        return new ApiInfoBuilder()
                .title("关系接口")
                .description("本文档描述了用户关系业务接口定义")
                .version("1.0")
                .build();
    }

    private ApiInfo workApiInfo() {

        return new ApiInfoBuilder()
                .title("就业接口")
                .description("本文档描述了就业业务接口定义")
                .version("1.0")
                .build();
    }

    private ApiInfo specialtyApiInfo() {

        return new ApiInfoBuilder()
                .title("专业信息接口")
                .description("本文档描述了专业信息业务接口定义")
                .version("1.0")
                .build();
    }

    private ApiInfo scoreApiInfo() {

        return new ApiInfoBuilder()
                .title("公研证明接口")
                .description("本文档描述了公研证明业务接口定义")
                .version("1.0")
                .build();
    }

    private ApiInfo replyApiInfo() {

        return new ApiInfoBuilder()
                .title("简历修订接口")
                .description("本文档描述了简历修订业务接口定义")
                .version("1.0")
                .build();
    }

    private ApiInfo resumeApiInfo() {

        return new ApiInfoBuilder()
                .title("简历接口")
                .description("本文档描述了简历业务接口定义")
                .version("1.0")
                .build();
    }

    private ApiInfo practiceApiInfo() {

        return new ApiInfoBuilder()
                .title("实习接口")
                .description("本文档描述了实习业务接口定义")
                .version("1.0")
                .build();
    }

    private ApiInfo monthlyApiInfo() {

        return new ApiInfoBuilder()
                .title("月报/总结接口")
                .description("本文档描述了月报业务接口定义")
                .version("1.0")
                .build();
    }
    private ApiInfo ApiInfo() {

        return new ApiInfoBuilder()
                .title("interview接口")
                .description("本文档描述了面试业务接口定义")
                .version("1.0")
                .build();
    }


    private ApiInfo adminApiInfo() {

        return new ApiInfoBuilder()
                .title("成绩接口")
                .description("本文档描述了成绩业务接口定义")
                .version("1.0")
                .build();
    }


    private ApiInfo counselorApiInfo() {

        return new ApiInfoBuilder()
                .title("角色权限接口")
                .description("本文档描述了角色权限类业务接口定义")
                .version("1.0")
                .build();
    }


    private ApiInfo studentApiInfo() {

        return new ApiInfoBuilder()
                .title("权限接口")
                .description("本文档描述了权限类业务接口定义")
                .version("1.0")
                .build();
    }

    private ApiInfo teacherApiInfo() {

        return new ApiInfoBuilder()
                .title("角色接口")
                .description("本文档描述了角色类业务接口定义")
                .version("1.0")
                .build();
    }

}
