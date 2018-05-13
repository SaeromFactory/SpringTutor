package com.watchers.service;

import com.watchers.repository.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ReplyService {
    @Autowired
    private ReplyMapper replymapper;
}
