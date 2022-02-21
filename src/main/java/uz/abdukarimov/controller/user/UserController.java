package uz.abdukarimov.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.abdukarimov.controller.BaseAbstractController;
import uz.abdukarimov.dto.task.TaskDto;
import uz.abdukarimov.dto.user.UserDto;
import uz.abdukarimov.dto.user.UserUpdateDto;
import uz.abdukarimov.service.task.TaskService;
import uz.abdukarimov.service.user.UserService;

import java.util.List;


@Controller
@RequestMapping("/user/*")
public class UserController extends BaseAbstractController<UserService> {

    private final TaskService taskService;

    public UserController(UserService service, TaskService taskService) {
        super(service);
        this.taskService = taskService;
    }

    @GetMapping("update/")
    public String updatePage() {
        return "/user/update";
    }


    @PostMapping("update/")
    public String update(@ModelAttribute UserUpdateDto userUpdateDto) {
        service.update(userUpdateDto);
        return "/home";
    }

    @GetMapping("user_info/{id}/")
    public ModelAndView get(@PathVariable Long id, ModelAndView modelAndView) {
        UserDto userDto = service.get(id);
        modelAndView.addObject("user", userDto);
        modelAndView.setViewName("/user/user_info");
        return modelAndView;
    }

    @GetMapping("profile/")
    public String profile(Model model) {
        UserDto userDto = service.list(null).get(0);
        List<TaskDto> userTasks = taskService.list(userDto.getId());
        model.addAttribute("tasks", userTasks);
        model.addAttribute("user", userDto);
        return "/user/profile";
    }

}
