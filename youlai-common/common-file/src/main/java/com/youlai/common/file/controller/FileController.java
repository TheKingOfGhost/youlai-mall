package com.youlai.common.file.controller;

import com.youlai.common.file.model.FileInfo;
import com.youlai.common.file.service.OssService;
import com.youlai.common.result.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "06.文件接口")
@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileController {

    private final OssService ossService;

    @PostMapping
    @Operation(summary= "文件上传")
    public Result<FileInfo> uploadFile(
            @Parameter(name = "表单文件对象") @RequestParam(value = "file") MultipartFile file
    ) {
        FileInfo fileInfo = ossService.uploadFile(file);
        return Result.success(fileInfo);
    }

    @DeleteMapping
    @Operation(summary= "文件删除")
    public Result deleteFile(
            @Parameter(name = "文件路径") @RequestParam String filePath
    ) {
        boolean result = ossService.deleteFile(filePath);
        return Result.judge(result);
    }

}
