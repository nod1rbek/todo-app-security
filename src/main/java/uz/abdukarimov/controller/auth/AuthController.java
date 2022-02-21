package uz.abdukarimov.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.abdukarimov.controller.BaseAbstractController;
import uz.abdukarimov.dto.user.UserCreateDto;
import uz.abdukarimov.service.auth.AuthUserService;


@Controller
@RequestMapping("/auth/*")
public class AuthController extends BaseAbstractController<AuthUserService> {

    public AuthController(AuthUserService service) {
        super(service);
    }

    @GetMapping("login/")
    public String loginPage() {
        return "/auth/login";
    }


    @GetMapping("logout/")
    public String logoutPage() {
        return "/auth/logout";
    }

    @GetMapping("register/")
    public String registrationPage() {
        return "auth/register";
    }


    @PostMapping("register/")
    public String registration(@ModelAttribute UserCreateDto userCreateDto) {
        service.registration(userCreateDto);
        return "redirect:/home";
    }

}
