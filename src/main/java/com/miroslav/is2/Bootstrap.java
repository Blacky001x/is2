package com.miroslav.is2;

import java.util.HashSet;
import java.util.Set;

import com.miroslav.is2.model.Category;
import com.miroslav.is2.model.Fact;
import com.miroslav.is2.model.Role;
import com.miroslav.is2.model.User;
import com.miroslav.is2.repository.FactRepository;
import com.miroslav.is2.repository.RoleRepository;
import com.miroslav.is2.service.CategoryService;
import com.miroslav.is2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private FactRepository factRepository;

	@Override
	public void run(String... args) throws Exception {

		Role r = new Role();
		r.setRole("ADMIN");
		r = roleRepository.save(r);

		Role r1 = new Role();
		r1.setRole("USER");
		r1 = roleRepository.save(r1);

		User u = new User();
		u.setActive(1);
		u.setEmail("example@example.com");
		u.setName("John");
		u.setLastName("Doe");
		u.setPassword("123123");
		userService.saveUser(u);

		userService.setAsAdmin(u);

		u = new User();
		u.setEmail("jovo@jovo.com");
		u.setName("jovo");
		u.setLastName("jovo");
		u.setPassword("111");
		userService.saveUser(u);

		Category c1 = new Category();
		c1.setName("Istorija");

		Category c2 = new Category();
		c2.setName("Programski jezici");

		categoryService.save(c1);
		categoryService.save(c2);

		Fact f1 = new Fact();
		f1.setCategory(c2);
		f1.setAllowed(true);
		f1.setContent("COBOL je programski jezik i ime je skraćenica od COmmon Business Oriented Language.\n" +
				"\n" +
				"COBOL je nastao 1959. kao plod rada Short Range Committee.\n" +
				"\n");

		Fact f2 = new Fact();
		f2.setCategory(c2);
		f2.setAllowed(true);
		f2.setContent("Korištenjem Erlanga, WhatsApp je krenuo u smjeru korištenja jezika u kojemu se mnogi procesi mogu istovremeno vrtiti. Kada pojedine usluge koriste deseci (u našem slučaju stotine) milijuna korisnika u isto vrijeme, potreba i popularnost takvih jezika je sve veća. Ujedno Erlang omogućuje i dopunjavanje koda iako je aplikaciju još uvijek u pogonu. Ovako se može još brže reagirati na probleme.");

		Fact f3 = new Fact();
		f3.setAllowed(true);
		f3.setContent("Abakus ili računaljka je sprava koja čoveku olakšava računanje, a ništa ne računa umesto njega. Ona se najšešće realizuje kao drveni okvir sa žicama po kojima se pomeraju kuglice. Vrednost kuglice zavisi od toga na kojoj se žici kuglica nalazi: na jednoj žici jedna kuglica ima vrednost 1, na sledećoj vrednost 10, na sledećoj vrednost 100. Dve kuglice na prvoj žici imaju vrednost 2, na drugoj vrednost 20, i tako dalje. Po tome abakus odgovara računanju u pozicionom brojnom sistemu. Sabiranje se ostvaruje pomeranjem kuglica u jednom smeru, a oduzimanje pomeranjem u drugom. Dakle, abakus je pomoćno memorijsko sredstvo i nema funkcije kakve će imati mehanički kalkulatori koji su nastali mnogo kasnije.");
		f3.setCategory(c1);

		Fact f4 = new Fact();
		f4.setAllowed(true);
		f4.setContent("Blez Paskal je 1642. godine kada je imao samo 19 godina otpočeo rad na mehaničkom kalkulatoru koji se naziva Pascaline. On je tada pomagao svom ocu koji je bio skupljač poreza i želeo je da mu olakša posao. Prvi model je izrađen 1645. godine, a 1652. godine izrađeno je već 50 prototipova, od kojih je više od 12 prodato. Cena i složenost mašine onemogućili su dalju proizvodnju, kao i činjenica da je samo Paskal lično mogao da je popravi. U to vreme, on je već imao druga naučna interesovanja.");

		Fact f5 = new Fact();
		f5.setAllowed(true);
		f5.setContent("Augusta Ada King, Countess of Lovelace (1815-1852), ćerka lorda Bajrona, je najzaslužnija za opis analitičke mašine Čarlsa Babidža preko koga je Babidžov rad postao poznat široj javnosti. Ada Avgusta je bila veoma talentovani matematičar, lično je poznavala Čarlsa Babidža i jedno vreme sa njim sarađivala. U toku devet meseci 1842. i 1843. godine je prevodila beleške jednog italijanskog matematičara o Babidžovoj analitičkoj mašini. Uz taj prevod je dodala i svoje beleške koje su sadržale detaljno opisan metod za izračunavanje Bernulijevih brojeva uz pomoć ove mašine. Mnogi istoričari njene beleške nazivaju prvim računarskim programom. Priznajući njene zasluge, Ministarstvo odbrane SAD-a je 1977. godine jedan programski jezik nazvalo njenim imenom - Ada.");

		factRepository.save(f1);
		factRepository.save(f2);
		factRepository.save(f3);
		factRepository.save(f4);
		factRepository.save(f5);


	}


	
	
}
