package ua.com.lig.spring.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import ua.com.lig.spring.controlers.entity.MappingData;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author karazhanov on 12.01.17.
 */
@RestController
@RequestMapping("/admin/")
public class AdminControler {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    private List<MappingData> mappingDatas;

    @PostConstruct
    public void init() {
        Map<RequestMappingInfo, HandlerMethod> handlerMethods =
                this.requestMappingHandlerMapping.getHandlerMethods();
        mappingDatas = new ArrayList<>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> item : handlerMethods.entrySet()) {
            RequestMappingInfo mapping = item.getKey();
            HandlerMethod method = item.getValue();

            for (String urlPattern : mapping.getPatternsCondition().getPatterns()) {
                String bean = method.getBeanType().getName();
                if (bean.startsWith("ua.com.lig.spring")) {
                    MethodParameter[] methodParameters = method.getMethodParameters();
                    Stream<MethodParameter> stream = Arrays.stream(methodParameters);
                    List<String> collect = stream.map(m -> m.getParameterType().getSimpleName()).collect(Collectors.toList());

                    String name = method.getBeanType().getName();
                    String[] split = name.split("\\.");
                    MappingData m = new MappingData(urlPattern,
                            split[split.length-1],
                            method.getMethod().getName(),
                            collect);
                    mappingDatas.add(m);
                }
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<MappingData> getAll() {
        return mappingDatas;
    }

}
