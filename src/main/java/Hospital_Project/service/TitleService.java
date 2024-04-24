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

    public void saveTitle(String doctorTitle, Doctor doctor) {

        Title title = new Title();
        title.setTitleName(doctorTitle);
        doctor.setTitle(title);
        titleRepository.save(title);

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
