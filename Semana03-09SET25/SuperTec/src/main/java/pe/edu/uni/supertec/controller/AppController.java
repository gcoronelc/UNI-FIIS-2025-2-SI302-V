/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.uni.supertec.controller;

import pe.edu.uni.supertec.dto.RepoDto;
import pe.edu.uni.supertec.service.AppService;

/**
 *
 * @author Usuario
 */
public class AppController {

	public RepoDto[] getRepoEstadistico() {
		AppService appService = new AppService();
		return appService.getEstadistica();
	}
	
}
