package org.delivery.storeadmin.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class PageController {

    @RequestMapping(path = {"","/main"}) //path: 배열로 받을 수 있음(주소 1개 이상)
    public ModelAndView main(){
        return new ModelAndView("main");
    }

    @RequestMapping("/order")
    public ModelAndView order(){
        return new ModelAndView("/order/order");
    }
}
