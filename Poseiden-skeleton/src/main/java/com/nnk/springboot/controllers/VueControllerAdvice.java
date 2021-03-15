package com.nnk.springboot.controllers;

import com.nnk.springboot.exceptions.EntityNotFoundException;
import com.nnk.springboot.exceptions.InvalidModelException;
import com.nnk.springboot.exceptions.UserAlreadyExistsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class VueControllerAdvice {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ModelAndView handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:register?error=userAlreadyExists");
        return mav;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView handleEntityNotFoundException(EntityNotFoundException e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("403");
        mav.addObject("errorMsg", e.getMessage());
        return mav;
    }

    @ExceptionHandler(InvalidModelException.class)
    public ModelAndView handleInvalidModelException(InvalidModelException e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("403");
        mav.addObject("errorMsg", e.getMessage());
        return mav;
    }
}
