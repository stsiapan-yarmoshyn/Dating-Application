package com.example.core_database_api.data

import com.example.core_database_api.data.dao.UserDaoApi

interface DbClientApi {

    val userDaoApi: UserDaoApi

}