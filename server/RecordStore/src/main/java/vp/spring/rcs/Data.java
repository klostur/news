package vp.spring.rcs;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.KategorijaRepository;
import vp.spring.rcs.data.VestRepository;
import vp.spring.rcs.model.Kategorija;
import vp.spring.rcs.model.Vest;

@Component
public class Data {
	@Autowired
	VestRepository vestRepo;
	@Autowired
	KategorijaRepository kateRepo;
	
	@PostConstruct
	public void init() {
		Kategorija k = new Kategorija("Zivot");
		kateRepo.save(k);
		k = new Kategorija("Sport");
		kateRepo.save(k);
		
		Vest v = new Vest("DARKO GLIŠIĆ (SNS): Dragačevci su pokazali",
				"Ponosan sam jer niko nije mogao ni da izmisli neku optužbu za SNS, rekao je Glišić", 
				"Lučani – Na izborima u Lučanima nijedan incident nije izazvao niko iz Srspke napredne stranke,  a lica koja su privođena prijavljena su da su pored naših aktivista napadali i birače i građane”, rekao je za Darko Glišić, predsednik IO SNS i dodao da je meštanin Kotraže koji nije član nijedne stranke prijavio opozicionare policiji zbog, kako je rekao, bahatog ponašanja. ", 
				kateRepo.findOne((long) 1));
		vestRepo.save(v);
		v = new Vest("MNOGO SAM ISKOMPLEKSIRANA, ZATO TO RADIM!", 
				"Nataša Bekvalac ističe da je ranije mislila da ukoliko odnos nije krunisan brakom - zapravo i ne postoji, odnosno da ta ljubav nije ozbiljna. Na samom kraju godine tokom koje je stavila tačku na treći brak, kaže: ", 
				"\"U meni se uvek odvija borba između onog što mi je kao mladoj ženi utemeljeno i onoga što sam u suštini uvek osećala, a to je da u dobrom odnosu formalnosti nisu bitne. Popuštala sam pod tim što nameće društvo, bila sam tradicionalna i konzervativna\", priznaje Gloriji, pa nastavlja: \"Borim se da budem društveno prihvatljiva jer sam mnogo iskompleksirana zbog toga što se ne ponašam u skladu sa okvirima koje postavlja društvo\". ",
				kateRepo.findOne((long) 1));
		vestRepo.save(v);
		v = new Vest("ZERINI ZBOG BANETA ODUZIMAJU ĆERKU?", 
				"Sukob Zerine Hećo i Baneta Čolaka jedna je od gorućih tema razgovora u Beloj kući. Međutim, da uvek može biti gore dokazuje situacija da je za crnim stolom, kada je izgubio živce zbog svega što se govorilo, Čolak ustao i pljunuo Zerinu. Ona je tada istrčala napolje u suzama. ", 
				"\"Smiri se. Nema vikanja. Ljudi sve vide, razumem da ti je teško. Samo se smiri i nemoj da pričaš\", mazio ju je on po leđima i govorio joj ne bi li prestala da plače i vrišti na sav glas od muke i bola.\n" + 
				"\n" + 
				" \n" + 
				"\n" + 
				"\"Treba da mi dete oduzmu zbog njega? Ubila bih ga na mrtvo! Da li si svestan gde se nalazimo?! Socijalni rad prati mene ovde! To nije svađa više! To se pretvara u nešto bolesno zbog čega mogu da imam probleme!\" nastavila je ipak da vrišti ona. ",
				kateRepo.findOne((long) 2));
		vestRepo.save(v);
		v = new Vest("ACO PEJOVIĆ IZVUKAO KECA IZ RUKAVA!", 
				"Sastanak je održan posle sednice Saveta bezbednosti UN o Kosmetu, na kojoj je govorio predsednik Srbije", 
				"Mali Perica pita mamu kako su ljudi nastali. Mama odgovara: - Pa, lepo. Bog nas je stvorio. - Ali tata kaže da smo nastali od majmuna - reče Perica. - Sine, ja ti pričam o mojima, a tata o svojima.",
				kateRepo.findOne((long) 1));
		vestRepo.save(v);
		v = new Vest("DARKU LAZIĆU HIRURZI SAOPŠTILI KLJUČNU VESTI",
				"Darko Lazić, koji je 23. oktorbra doživeo tešku saobraćajnu nesreću, danas je, posle tri nedelje boravka u banji Selters, bio na prvoj kontroli",
				"\"Fenomenalno sam. Lekari kažu da su super, zadovoljni su i da treba strpljenja. Glavni doktor je rekao da sam dobro napredovao. Ja sam zadovoljan, on je zadovoljan. Bilo mi je naporno na početku, sad se navikavam\", rekao je pevač, koji je sve vreme bio nasmejan, budući da je dobio dobre vesti. \n" + 
				"\n" + 
				" \n" + 
				"\n" + 
				"Kada je ulazio u kombi, Darko je poručio: \"Kao Ledi Gaga sam\"!, iz njene pesme \"Paparaco\". ",
				kateRepo.findOne((long) 2));
		vestRepo.save(v);
		v = new Vest("TUGA U ZAJEČARU, MONSTRUOZNOST NEMA GRANICA: Štenci upali u septičku jamu!",
				"ZAJEČAR - Da ljudska monstruoznost često prevazilazi i najteža očekivanja pokazao je poslednji slučaj zanemarivanja životinja u Zaječaru koji je duboko potresao celu Srbiju. ",
				"Naime, kako je objavljeno na Fejsbuk stranici Udruženja \"Beta\", i njih je bez teksta ostavila teška sudbina dva psića koji su, kako se pretpostavlja nesrećnim slučajem, upali u septičku jamu. Nesrećni mladunci su potom dva dana zapomagali, ostavljeni na cedilu po ovoj hladnoći i u fekalijama, a posebno zapanjujuće je što niko od prolaznika nije reagovao. Naprotiv, išli su svojim putem ni ne pomišljajući da pomognu. Srećom, dobrih ljudi ima, te je sve krenule od jedne devojke koja je alarmirala udruženje, a aktivisti su se odmah zaputili na teren. ",
				kateRepo.findOne((long) 2));
		vestRepo.save(v);
		
	}
}
