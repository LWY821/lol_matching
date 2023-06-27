package com.woo.mating.controller;


import com.woo.mating.DTO.MemberDTO;
import com.woo.mating.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.aspectj.weaver.ast.Test;
import org.springframework.web.bind.annotation.*;

@RestController
public class LolController {

    private final MemberService memberService;

    public LolController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/home")
    public String home() {
        return ("나는야 우영");
    }

    @GetMapping("/register")
    public String loginForm() {
        return ("회원가입");
    }
    @GetMapping("/login")
    public String login1(){
        return("Email,Password");
    }

//    @PostMapping("/login")
//    public String login2(@RequestBody Test userInfo) {
//
//        return null;
//    }

    @PostMapping("/register")
    public String register(@RequestBody MemberDTO memberDTO) {
        System.out.println("MemberController.register");
        System.out.println("memberDTO=" + memberDTO);
        memberService.register(memberDTO);
        return "login";
    }
    @PostMapping("/login")
    public String login1(@RequestBody MemberDTO memberDTO, HttpSession session){
        MemberDTO loginResult= memberService.login(memberDTO);
        if (loginResult !=null){
            session.setAttribute("loginEmail",loginResult.getMemberEmail());
            return ("main");
        }else{
            return ("login");
        }
    }
//        if (userInfo.getEmail().equals("hamin@naver.com"))
//            return "잘못된 이메일";
//
//        if (userInfo.getName().equals("하민")) {
//            return "회원가입성공!";
//
//        } else if (userInfo.getName().equals("우영")) {
//            return "회원가입실패ㅠ";
//        } else {
//            return "???";
//        }
//    }
//    유저인포에 네임이 하민이면 트루 우영이면 폴스.만약 이메일이 하민@네이버
//    @PostMapping("/register")
//    public String register(@ModelAttribute MemberDTO memberDTO) {

    //        if (userInfo.getEmail().equals("hamin@naver.com"))
//            return  "잘못된 이메일";
//
//        if (userInfo.getName().equals("하민")) {
//            return "회원가입성공!" ;
//
//        } else if (userInfo.getName().equals("우영")){
//            return "회원가입실패ㅠ";
//        }else{
//            return ("/login");
//        }
//    }
//    @PostMapping("/home")
//    public String login(@ModelAttribute MemberDTO memberDTO) {
//        System.out.println("MemberController.register");
//        System.out.println("memberDTO=" + memberDTO);
//        memberService.register(memberDTO);
//        return ("/login");
//    }
//    @PostMapping("/login")
//    public String login(@ModelAttribute MemberDTO memberDTO){
//        MemberDTO loginResult= memberService.login(memberDTO);
//        if (loginResult !=null){
//            session.setAttribute("loginEmail",loginResult.getMemberEmail());
//        if()
//        return ("홈");
//        }else {
//            return ("로그인");
//        }
//    }
//    }
//    @PostMapping("/register")
//    public String register2(@RequestBody Test userInfo) {
//
//        if (userInfo.getEmail().equals("hamin@naver.com"))
//            return  "잘못된 이메일";
//
//        if (userInfo.getName().equals("하민")) {
//            return "회원가입성공!" ;
//
//        } else if (userInfo.getName().equals("우영")){
//            return "회원가입실패ㅠ";
//        }else{
//            return "???";
//        }
//    }
//
////    @GetMapping("/register")
////    public String register3(@RequestBody Test userInfo) {
////
////        if (userInfo.getEmail().equals("hamin@naver.com"))
////            return  "잘못된 이메일";
////
////        if (userInfo.getName().equals("하민")) {
////            return "회원가입성공!" ;
////
////        } else if (userInfo.getName().equals("우영")){
////            return "회원가입실패ㅠ";
////        }else{
////            return "???";
////        }
////    }
//
//
//}
//
     class  Test {
        String name;
        String email;

        public String getEmail() {
            return email;

        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

