package com.dev.JobPortal.services;

import com.dev.JobPortal.entity.JobSeekerProfile;
import com.dev.JobPortal.entity.RecruiterProfile;
import com.dev.JobPortal.entity.Users;
import com.dev.JobPortal.repository.JobSeekerProfileRepository;
import com.dev.JobPortal.repository.RecruiterProfileRepository;
import com.dev.JobPortal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class usersService {

    private UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

    @Autowired
    public usersService(UsersRepository usersRepository,JobSeekerProfileRepository jobSeekerProfileRepository,RecruiterProfileRepository recruiterProfileRepository) {
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository=jobSeekerProfileRepository;
        this.recruiterProfileRepository=recruiterProfileRepository;
    }

    public Users addNew(Users users){

        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        int userTypeId = users.getUserTypeId().getUserTypeId();
         Users savedUser = usersRepository.save(users);
        if(userTypeId==2){
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }
        recruiterProfileRepository.save(new RecruiterProfile(savedUser));

        return savedUser;

    }

    public Optional<Users> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

}
