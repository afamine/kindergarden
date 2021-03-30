package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import tn.esprit.spring.dto.ChildDTO;
import tn.esprit.spring.dto.UserDataDTO;
import tn.esprit.spring.dto.UserResponseDTO;
import tn.esprit.spring.entities.Child;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
@Api(tags = "users")
public class UserController {

  @Autowired
  private UserServiceImpl userService;
  

  
  @Autowired
  private UserRepository userRep;

  @Autowired
  private MessageSource messages;
  @Autowired
  private ModelMapper modelMapper;
  /*@GetMapping("/regitrationConfirm")
  public String confirmRegistration
    (WebRequest request, Model model, @RequestParam("token") String token) {
   
      Locale locale = request.getLocale();
      
      VerificationToken verificationToken = userService.getVerificationToken(token);
      if (verificationToken == null) {
          String message = messages.getMessage("auth.message.invalidToken", null, locale);
          model.addAttribute("message", message);
          return "redirect:/badUser.html?lang=" + locale.getLanguage();
      }
      
      User user = verificationToken.getUser();
      Calendar cal = Calendar.getInstance();
      if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
          String messageValue = messages.getMessage("auth.message.expired", null, locale);
          model.addAttribute("message", messageValue);
          return "redirect:/badUser.html?lang=" + locale.getLanguage();
      } 
      
      user.setEnabled(true); 
      userService.saveRegisteredUser(user); 
      return "redirect:/login.html?lang=" + request.getLocale().getLanguage(); 
  }*/
  
  // Authentification 
  @PostMapping("/signin")
  @ApiOperation(value = "${UserController.signin}")
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 422, message = "Invalid username/password supplied")})
  public String login(//
      @ApiParam("Username") @RequestParam String username, //
      @ApiParam("Password") @RequestParam String password) {
    return userService.signin(username, password);
  }
  // Inscription 
  @PostMapping("/signup")
  @ApiOperation(value = "${UserController.signup}")
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 422, message = "Username is already in use")})
  public String signup(@ApiParam("Signup User") @RequestBody UserDataDTO user) {
	  
    return "You're registred successfully ! "+userService.signup(user);
  }
 // delete user by username

  @DeleteMapping(value = "/{username}")
  @PreAuthorize("hasRole('ROLE_PARENT')")
  @ApiOperation(value = "${UserController.delete}")
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 404, message = "The user doesn't exist"), //
      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public String delete(@ApiParam("Username") @PathVariable String username) {
    userService.delete(username);
    return "User "+username+" is deleted ";
  }
  //Search advanced 
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @GetMapping("/search")
    public List<User> findAll(
            @RequestParam Optional<String> username) {
        // Sort by added
        return userRep.findByName(username.orElse("_"));
    }
  //Sort by username
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PARENT')")
  @GetMapping(value = "/usersbyname")
    public List<User> getUsersSortedByUsername() {

        return userService.findAllOrderByUsernameAsc();
    }
  // search by username 
  @GetMapping(value = "find/{username}")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PARENT')")
  @ApiOperation(value = "${UserController.search}", response = UserResponseDTO.class, authorizations = { @Authorization(value="apiKey") })
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 404, message = "The user doesn't exist"), //
      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public UserResponseDTO search(@ApiParam("Username") @PathVariable String username) {
    return modelMapper.map(userService.search(username), UserResponseDTO.class);
  }
  //afficher user by Id
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @GetMapping("/{id}")
  public User getUserById(@PathVariable(value = "id") Long id)
  {
      return userRep.findById(id);
  }
  // Pagination
  @PreAuthorize("hasRole('ROLE_PARENT')")
  @RequestMapping(value = "/queryByPage", method = RequestMethod.GET)
  public Page<User> queryByPage(Pageable pageable) {
      Page<User> pageInfo = userService.listByPage(pageable);
      return pageInfo;
  }
  // Current user 
  @GetMapping(value = "/me")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PARENT')")
  @ApiOperation(value = "${UserController.me}", response = UserResponseDTO.class, authorizations = { @Authorization(value="apiKey") })
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public UserResponseDTO whoami(HttpServletRequest req) {
    return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
  }
// Refresh ( token ) 
  @GetMapping("/refresh")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PARENT')")
  public String refresh(HttpServletRequest req) {
    return userService.refresh(req.getRemoteUser());
  }
 // Add Child by parent
  @PreAuthorize("hasRole('ROLE_PARENT')")
  @RequestMapping(value="/addChild", method = RequestMethod.POST)
  	  public Child saveChild(@RequestBody ChildDTO child){
  	    	
  	     return userService.save(child);    
  	    }
  //Update user 
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PARENT')  or hasRole('ROLE_DOCTOR')  or hasRole('ROLE_DIRECTOR')")
  @PutMapping("/update/{id}")
	    public User updateUser(@PathVariable(value = "id") Long userId,
	                                           @Valid @RequestBody UserDataDTO userDetails) {

	        User user = userRep.findById(userId);
	            
	        user.setUsername(userDetails.getUsername());
	        user.setPassword(userDetails.getPassword());
	        user.setPassword(userDetails.getEmail());
	        user.setRoles(userDetails.getRoles());

	        User updatedUser = userRep.save(user);
	        return updatedUser;
	    }
  /*
  @PreAuthorize("hasRole('ROLE_PARENT')")
  @GetMapping("/users/export/pdf")
  public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
      response.setContentType("application/pdf");
      DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
      String currentDateTime = dateFormatter.format(new Date());
       
      String headerKey = "Content-Disposition";
      String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
      response.setHeader(headerKey, headerValue);
       
      List<User> listUsers = userService.listAll();
       
      UserPDFExporter exporter = new UserPDFExporter(listUsers);
      exporter.export(response);
       
  }*/
  
  
}
