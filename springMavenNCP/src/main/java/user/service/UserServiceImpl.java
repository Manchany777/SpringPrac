package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserImageDTO;
import user.dao.UserDAO;

@Service
@Transactional // 메서드마다 일일이 트랜잭션 걸어도 된다.
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ObjectStorageService objectStorageService;
	
	private String bucketName = "bitcamp-edu-bucket-112";
	
	@Override
	public void upload(List<UserImageDTO> userImageList) {
		userDAO.upload(userImageList);
	}
	
	@Override
	public List<UserImageDTO> getUploadList() {
		return userDAO.getUploadList();
	}

	@Override
	public void deleteList(int seq) {
		String imageFileName = "storage/";
		imageFileName+=userDAO.getImageFileName(seq);
		
		System.out.println("UserServiceImpl : " + imageFileName);
		objectStorageService.deleteList(bucketName, imageFileName);
		
		userDAO.deleteList(seq);
	}

	@Override
	public UserImageDTO getImageFileName(int seq) {
		UserImageDTO userImageDTO = userDAO.getImageFileName(seq);
		
		userImageDTO.setSeq(seq);
		userImageDTO.setImageName(userImageDTO.getImageName());
		userImageDTO.setImageContent(userImageDTO.getImageContent());
		userImageDTO.setImageFileName(userImageDTO.getImageFileName());
		userImageDTO.setImageOriginalName(userImageDTO.getImageOriginalName());
		
		return userImageDTO;
	}

	@Override
	public void update(UserImageDTO dto) {
		System.out.println("서비스단 이미지파일네임 : " + dto.getImageFileName());
		System.out.println("서비스단 오리지널네임 : " + dto.getImageOriginalName());
		System.out.println("서비스단 seq : " + dto.getSeq());
		//userDAO.update(dto);
		userDAO.update(dto);
	}
	
	/*
	@Override
	public void update(UserImageDTO userImageDTO, MultipartFile imgFile, HttpSession session) {
		System.out.println("서비스단 이미지파일네임 : " + userImageDTO.getImageFileName());
		System.out.println("서비스단 오리지널네임 : " + userImageDTO.getImageOriginalName());
		
		// 실제 폴더
		String filepath = session.getServletContext().getRealPath("/WEB-INF/storage");
		System.out.println("실제폴더 = " + filepath);
		
		File file;
		String originalFileName;
		//String result = ""; // 상품등록 완료 확인
		String fileName;
		
		originalFileName = imgFile.getOriginalFilename();
		System.out.println(originalFileName);
		
		
		//삭제
		String imageFileName="storage/";
		imageFileName+=userDAO.getImageFileName(userImageDTO.getSeq());
		objectStorageService.deleteList(bucketName, imageFileName);
		System.out.println("삭제 imageFileName : " + userDAO.getImageFileName(userImageDTO.getSeq()));
		userDAO.deleteList(userImageDTO.getSeq());
		
		
		//업로드
		fileName = objectStorageService.uploadFile(bucketName, "storage/", imgFile); 
		file = new File(filepath, originalFileName);
		
		try {
			imgFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("업데이트 파일 이름 : " + file);
		
		UserImageDTO dto = new UserImageDTO();
		dto.setImageName(userImageDTO.getImageName()); // 상품명
		dto.setImageContent(userImageDTO.getImageContent()); // 상품내용
		//dto.setImageFileName("");		 // UUID - Object에 올라갈 수 있도록 처리애햐함(클라우드에서 이름을 받아올 거라 여기선 공백으로 둔다.)
		//dto.setImageFileName("noname");  // 현재는 "noname"이 뜨게 바꿈
		dto.setImageFileName(fileName);  // NCloud에 UUID로 fileName 삽입
		dto.setImageOriginalName(originalFileName);
		
		System.out.println("업데이트 DTO 이름 : " + dto.getImageOriginalName());	
		userDAO.update(dto);
		
	}*/
}