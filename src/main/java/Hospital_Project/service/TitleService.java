package Hospital_Project.service;

import Hospital_Project.domain.Doctor;
import Hospital_Project.domain.Title;
import Hospital_Project.exceptions.TitleNotFoundException;
import Hospital_Project.repository.TitleRepository;

import static Hospital_Project.service.HospitalService.scan;

public class TitleService {
    private final TitleRepository titleRepository;

    public TitleService(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    public void addTitle() {

        Title title = new Title();
        title.setTitleName("Allergist");
        Title title1 = new Title();
        title1.setTitleName("Norolog");
        Title title2 = new Title();
        title2.setTitleName("Genel cerrah");
        Title title3 = new Title();
        title3.setTitleName("Cocuk doktoru");
        Title title4 = new Title();
        title4.setTitleName("Dahiliye");
        Title title5 = new Title();
        title5.setTitleName("Kardiolog");

        titleRepository.save(title);
        titleRepository.save(title1);
        titleRepository.save(title2);
        titleRepository.save(title3);
        titleRepository.save(title4);
        titleRepository.save(title5);
        System.out.println(title);
        System.out.println(title1);
        System.out.println(title2);

    }
    public Title saveTitle() {
        Title title = new Title();
        System.out.println("Lütfen eklemek istediğiniz ünvanı giriniz : ");
        title.setTitleName(scan.nextLine());
        titleRepository.save(title);
        return title;
    }

    public Title findTitleByName() {

        System.out.println("Bulmak Istediginiz Doktorun Unvanini Giriniz:\n\t=> Allergist\n\t=> Norolog\n\t" +
                "=> Genel Cerrah\n\t=> Cocuk Doktoru\n\t=> Dahiliye Uzmanı\n\t=> Kardiolog");
        try {
            String titleName = scan.nextLine();

            Title foundTitle = titleRepository.findTitleByName(titleName);
            if (foundTitle != null) {
                return foundTitle;
            } else {
                throw new TitleNotFoundException("Title is not found by this name : " + titleName);
            }
        } catch (TitleNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void updateTitle(Title title) {
        titleRepository.update(title);
    }
}
