package dev.triamylo.workingplacebooking.controller;

import dev.triamylo.workingplacebooking.model.User;
import dev.triamylo.workingplacebooking.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @Test
    public void addUserTest() throws Exception {

        //define a sample user to return when userService.add is called
        User user = new User("username", "password", "first", "last", "user@test.com");
        mockMvc.perform(MockMvcRequestBuilders.post("/user/add")
                        .flashAttr("user", user))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/user/userList"))
                .andDo(print());

        //verify userService.add was called once
        verify(userService).add(userCaptor.capture());

        //assert that the passed User object matches the expected result
        List<User> capturedUsers = userCaptor.getAllValues();

        // we used a responseBody so even though there is only one user it should be in a list hence, Arrays.asList
        assertThat(capturedUsers).isEqualTo(Arrays.asList(user));

    }
}